import { BrowserModule } from '@angular/platform-browser';
import {Injector, NgModule} from '@angular/core';
import {APP_BASE_HREF, DatePipe} from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { HomeComponent } from './components/home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {BookService} from './service/book.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginStatusComponent } from './components/login-status/login-status.component';
import {OKTA_CONFIG, OktaAuthModule} from '@okta/okta-angular';
import {Router} from '@angular/router';
import myAppConfig from './config/my-app-config';
import {OktaCallbackComponent} from '@okta/okta-angular';
import {authInterceptorProviders} from './helpers/auth.interceptor';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';

const oktaConfig = Object.assign({
  onAuthRequired: (oktaAuth: any, injector: Injector) => {
    const router = injector.get(Router);
    router.navigate(['/login']);
  }}, myAppConfig.oidc);

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProductDetailComponent,
    HomeComponent,
    LoginStatusComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    // NgxPaginationModule,
    NgbModule,
    OktaAuthModule,
    ReactiveFormsModule,
    FormsModule
  ],
  // providers: [BookService, DatePipe, { provide: OKTA_CONFIG, useValue: oktaConfig }],
  providers: [authInterceptorProviders,
    JwtHelperService,
    {provide: JWT_OPTIONS, useValue: JWT_OPTIONS},
    {provide: APP_BASE_HREF, useValue: '/'}, BookService, DatePipe, { provide: OKTA_CONFIG, useValue: oktaConfig }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

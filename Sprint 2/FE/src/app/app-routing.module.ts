import {NgModule} from '@angular/core';
import {Routes, RouterModule, Router} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {ProductDetailComponent} from './components/product-detail/product-detail.component';
import {HomeComponent} from './components/home/home.component';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {
  // OKTA_CONFIG,
  // OktaAuthModule,
  OktaCallbackComponent
} from '@okta/okta-angular';

import myAppConfig from './config/my-app-config';
import {CartDetailsComponent} from './components/cart-details/cart-details.component';
import {CheckoutComponent} from './components/checkout/checkout.component';

// const oktaConfig = Object.assign({
//   onAuthRequired: (injector) => {
//     const router = injector.get(Router);
//
//     // Redirect the user to your custom login page
//     router.navigate(['/login']);
//   }
// }, myAppConfig.oidc)
const routes: Routes = [
  {path: 'login/callback', component: OktaCallbackComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'books/:id', component: ProductDetailComponent},
  {path: 'search/:keyword', component: HomeComponent},
  {path: 'category/:id', component: HomeComponent},
  {path: 'category', component: HomeComponent},
  {path: 'books', component: HomeComponent},
  {path: '', redirectTo: '/books', pathMatch: 'full'},
  {path: '**', redirectTo: '/books', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

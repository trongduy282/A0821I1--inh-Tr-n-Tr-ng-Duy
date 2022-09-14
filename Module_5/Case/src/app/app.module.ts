import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {AddServiceComponent} from './add-service/add-service.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {ContractListComponent} from './contract-list/contract-list.component';
import {ContractComponent} from './contract/contract.component';
import { HomeComponent } from './home/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    EditServiceComponent,
    AddServiceComponent,
    CustomerListComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    ContractListComponent,
    ContractComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

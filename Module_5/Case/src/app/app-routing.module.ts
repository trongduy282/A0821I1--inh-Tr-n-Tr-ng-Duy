import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {ContractListComponent} from './contract-list/contract-list.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {HomeComponent} from './home/home/home.component';


const routes: Routes = [
  {
    path: 'customer/edit/:id', component: CreateCustomerComponent
  },
  {
    path: '', component: CustomerListComponent
  },
  {
    path: 'customer/create', component: CreateCustomerComponent
  },
  {
    path: 'contact', component: ContractListComponent
  },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'facilities',
    loadChildren: () => import('./facility/facility.module').then(m => m.FacilityModule)
  } // cái ni là đường link dẫn qua module facilility // create, edit, delete do file facility-routing xử lý
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

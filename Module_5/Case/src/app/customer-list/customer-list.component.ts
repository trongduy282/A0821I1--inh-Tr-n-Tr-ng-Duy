import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerServiceService} from '../customer/customer-service.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] ;
  customerDelete: Customer;
  p = 1;
  searchText = '';
  constructor(private customerService: CustomerServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.customerService.findAll().subscribe(
      customers => this.customers = customers
    );
  }
  findCustomerDelete(id: number) {
    this.customerDelete = this.customers.find(c => c.id === id);
  }

  delete() {
    this.customerService.deleteById(this.customerDelete.id).subscribe(
      next => {
        this.getAll();
      }
    );
  }
  search() {
    this.customerService.search(this.searchText).subscribe(
      customers => this.customers = customers
    );
  }
}

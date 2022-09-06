import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [
    // tslint:disable-next-line:max-line-length
    {id: '1', name: 'Duy', gender: true, identity: '1', phone_number: '079123456', email: 'duydinh@gmail.com', address: 'da nang', customer_type: 'Villa'},
    // tslint:disable-next-line:max-line-length
    {id: '2', name: 'Hoang', gender: false, identity: '2', phone_number: '079123457', email: 'hoang@gmail.com', address: 'tam ky', customer_type: 'House'},
    // tslint:disable-next-line:max-line-length
    {id: '3', name: 'Viet', gender: true, identity: '3', phone_number: '079123458', email: 'viet@gmail.com', address: 'hue', customer_type: 'Room'}
  ];
  constructor() { }

  ngOnInit(): void {
  }

}

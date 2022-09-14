import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../customer';
import {CustomerType} from '../customer-type';

const API_URL = 'http://localhost:3000/customer';
@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(API_URL + '/' + id);
  }
  save(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL, customer);
  }

  update(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(API_URL + '/' + id, customer);
  }

  deleteById(id: number): Observable<Customer> {
    return this.http.delete<Customer>(API_URL + '/' + id);
  }

  search(v: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '?name_like=' + v);
  }

  // search(name: string, email: string, typeId: string): Observable<Customer[]> {
  //   // + '&type.id_like=' + typeId
  //   return this.http.get<Customer[]>(API_URL + '?name_like=' + name + '&email_like=' + email);
  // }
  getCustomerTypes(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customer_types');
  }
}

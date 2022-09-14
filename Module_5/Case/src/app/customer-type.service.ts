import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from './customer-type';
const API_URL = 'http://localhost:3000/customer_types';
@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL);
  }
}

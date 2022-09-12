import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ITodo} from "../app/ITodo";
import {HttpClient} from "@angular/common/http";
const API_URL = "http://localhost:3000";
@Injectable({
  providedIn: 'root'
})
export class ServiceTodoService {

  constructor(private _httpClient:HttpClient) { }
  getAll():Observable<ITodo[]>{
    return this._httpClient.get<ITodo[]>(API_URL+'/todo');
  }
  save(todo:ITodo):Observable<ITodo>{
    return this._httpClient.post<ITodo>(API_URL +'/todo', todo);
  }
  getById(id):Observable<ITodo>{
    return this._httpClient.get<ITodo>(API_URL+'/todo'+'/'+id);
  }
  update(id:number ,todo):Observable<ITodo>{
    return this._httpClient.put<ITodo>(API_URL+'/todo'+'/'+id, todo);
  }
  delete(id:number):Observable<ITodo>{
    return this._httpClient.delete<ITodo>(API_URL+'/todo'+'/'+id);
  }
}

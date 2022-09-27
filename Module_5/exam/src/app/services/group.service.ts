import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Student} from '../models/student';
import {HttpClient} from '@angular/common/http';
import {Group} from '../models/group';
import {environment} from '../../environments/environment';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Group[]> {
    return this.http.get<Group[]>(API_URL + 'groups');
  }
}

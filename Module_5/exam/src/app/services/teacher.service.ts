import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Group} from '../models/group';
import {Student} from '../models/student';
import {HttpClient} from '@angular/common/http';
import {Teacher} from '../models/teacher';
import {environment} from '../../environments/environment';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(API_URL + 'teachers');
  }
}

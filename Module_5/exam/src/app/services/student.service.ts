import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Student} from '../models/student';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

const URL_API = `${environment.apiUrl}` + 'students';
// http://localhost:8080/api/students => đường dẫn gọi qua back end xử lý
// Trên trình duyệt gõ như file routing

@Injectable({
  providedIn: 'root'
})
// file ni gọi bên backend
export class StudentService {

  constructor(private http: HttpClient) {
  }
// page=${index}&size=${3}
//   getAllStudentsWithPage(page: number): Observable<Student[]> {
//     return this.http.get<Student[]>(URL_API + '?page=' + page);
//   }

  getAllStudentsWithPage(page: number): Observable<Student[]> {
    return this.http.get<Student[]>(URL_API + `?page=${page}&size=${3}`);
  }
  getAllStudentsNotPagination(): Observable<Student[]> {
    return this.http.get<Student[]>(URL_API + '/not-pagination');
  }

  create(student: Student): Observable<Student> {
    return this.http.post<Student>(URL_API + '/create', student);
  }

  update(student: Student): Observable<Student> {
    return this.http.put<Student>(URL_API + '/' + student.id, student);
  }

  findById(id: number): Observable<Student> {
    return this.http.get<Student>(URL_API + '/' + id);
  }

  deleteById(id: number): Observable<Student> {
    return this.http.delete<Student>(URL_API + '/' + id);
  }

  //
  // search(v: string): Observable<Student[]> {
  //   return this.http.get<Student[]>(API_URL + '?name_like=' + v);
  // }
}

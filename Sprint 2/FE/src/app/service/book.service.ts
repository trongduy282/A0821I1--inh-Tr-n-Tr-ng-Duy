import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../common/book';
import {map} from 'rxjs/operators';
import {BookCategory} from '../common/book-category';

@Injectable({
  providedIn: 'root'
})
export class BookService {


  private baseUrl = 'http://localhost:8080/books';
  private categoryUrl = 'http://localhost:8080/book-category';

  constructor(private httpClient: HttpClient) { }
  getBook(theBookId: number): Observable<Book> {

    // need to build URL based on book id
    const bookUrl = `${this.baseUrl}/${theBookId}`;

    return this.httpClient.get<Book>(bookUrl);
  }
  getBookListPaginate(thePage: number,
                      thePageSize: number,
                      theCategoryId: number): Observable<GetResponseBooks> {

    // need to build URL based on category id, page and size
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`
      + `&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<GetResponseBooks>(searchUrl);
  }
  getBookList(theCategoryId: number): Observable<Book[]> {

    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

    return this.getBooks(searchUrl);
  }

  searchBooks(theKeyword: string): Observable<Book[]> {

    // need to build URL based on the keyword
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;

    return this.getBooks(searchUrl);
  }
  private getBooks(searchUrl: string): Observable<Book[]> {
    return this.httpClient.get<GetResponseBooks>(searchUrl).pipe(map(response => response._embedded.books));
  }
  // getBookList(): Observable<Book[]> {
  //   return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
  //     map(response => response._embedded.books)
  //   );
  // }
  getBookCategories(): Observable<BookCategory[]> {

    return this.httpClient.get<GetResponseBookCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.bookCategory)
    );
  }
}
interface GetResponseBooks  {
  _embedded: {
    books: Book[];
  }; page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  };
}
interface GetResponseBookCategory {
  _embedded: {
    bookCategory: BookCategory[];
  };
}

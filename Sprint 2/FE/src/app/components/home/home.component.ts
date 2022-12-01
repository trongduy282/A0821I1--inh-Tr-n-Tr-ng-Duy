import {Component, OnDestroy, OnInit} from '@angular/core';
// ChangeDetectionStrategy
import myAppConfig from '../../config/my-app-config';
import {OktaAuthService} from '@okta/okta-angular';
import {BookService} from '../../service/book.service';
import {Book} from '../../common/book';
import {ActivatedRoute, Router} from '@angular/router';
import {BookCategory} from '../../common/book-category';
import * as OktaSignIn from '@okta/okta-signin-widget';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {CartItem} from '../../common/cart-item';
import {CartService} from '../../services/cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  // changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent implements OnInit {
  totalPrice = 0.00;
  totalQuantity = 0;
  oktaSignin: any;
  isAuthenticated = false;
  userFullName: string;

  bookCategories: BookCategory[] = [];
  currentCategoryId = 1;
  previousCategoryId = 1;
  keyword: string;
  books: Book[] = [];
  page = 1;

  // new properties for pagination
  thePageNumber = 1;
  thePageSize = 2;
  theTotalElements = 0;

  constructor(private bookService: BookService,
              private router: Router,
              private route: ActivatedRoute,
              private oktaAuthService: OktaAuthService,
              private cartService: CartService,
              private tokenStorageService: TokenStorageService) {
    // this.oktaSignin = new OktaSignIn({
    //   logo: 'assets/images/logo/logo.png',
    //   features: {
    //     registration: true
    //   },
    //   baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
    //   clientId: myAppConfig.oidc.clientId,
    //   redirectUri: myAppConfig.oidc.redirectUri,
    //   authParams: {
    //     pkce: true,
    //     issuer: myAppConfig.oidc.issuer,
    //     scopes: myAppConfig.oidc.scopes
    //   }
    // });
    // this.oktaAuthService.$authenticationState.subscribe(
    //   isAuth => this.isAuthenticated = isAuth
    // );
  }

  ngOnInit(): void {
    this.updateCartStatus();
    this.route.paramMap.subscribe(() => {
      this.listBooks();
    });
    this.isAuthenticated = this.tokenStorageService.isAuthenticated();
    this.listBooks();
    this.listBookCategories();
    // this.isAuthenticated = await this.oktaAuthService.isAuthenticated();
    //
    // if (this.isAuthenticated) {
    //   // const userClaims = await this.oktaAuthService.getUser();
    //   // this.name = userClaims.name || "";
    //   await this.oktaAuthService.getUser().then(
    //     (res) => {
    //       this.userFullName = res.name;
    //     }
    //   );
    // }

    // this.isAuthenticated = await this.oktaAuthService.isAuthenticated();
    // if (this.isAuthenticated) {
    //   const userClaims = await this.oktaAuthService.getUser();
    //   this.name = userClaims.name || "";
    // }
    // Subscribe to authentication state changes
    // this.oktaAuthService.$authenticationState.subscribe(
    //   (result) => {
    //     this.isAuthenticated = result;
    //     this.getUserDetails();
    //   }
    // );

    // this.oktaSignin.remove();
    //
    // this.oktaSignin.renderEl({
    //     el: '#okta-sign-in-widget'
    //   }, // this name should be same as div tag id in login.component.html
    //   (response) => {
    //     if (response.status === 'SUCCESS') {
    //       this.oktaAuthService.signInWithRedirect();
    //     }
    //   },
    //   (error: any) => {
    //     throw error;
    //   }
    // );
  }
  getUserDetails() {
    // if (this.isAuthenticated) {
    //
    //   // Fetch the logged in user details (user's claims)
    //   //
    //   // user full name is exposed as a property name
    //   this.oktaAuthService.getUser().then(
    //     (res) => {
    //       this.userFullName = res.name;
    //     }
    //   );
    // }
  }

  logout() {
    // Terminates the session with Okta and removes current tokens.
    // this.oktaAuthService.signOut();
    this.isAuthenticated = false;
    this.tokenStorageService.signOut();
  }

  listBooks() {
    if (this.keyword === undefined) {
      this.keyword = this.route.snapshot.paramMap.get('keyword');
    }
    if (this.keyword === null || this.keyword === '') {
      this.handleListProducts();
    } else {
      this.handleSearchProducts();
    }

  }
  // listBooks() {
  //   // this.bookService.getBookList().subscribe(
  //   //   data => {
  //   //     this.books = data;
  //   //   }
  //   // );
  //   // check if "id" parameter is available
  //   const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
  //
  //   if (hasCategoryId) {
  //     // get the "id" param string. convert string to a number using the "+" symbol
  //     this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
  //   } else {
  //     // not category id available ... default to category id 1
  //     this.currentCategoryId = 1;
  //   }
  //
  //   // now get the products for the given category id
  //   this.bookService.getBookList(this.currentCategoryId).subscribe(
  //     data => {
  //       this.books = data;
  //     }
  //   );
  // }
  listBookCategories() {
    this.bookService.getBookCategories().subscribe(
      data => {
        // console.log('Product Categories=' + JSON.stringify(data));
        this.bookCategories = data;
        console.log(data);
      }
    );
  }
  doSearch(value: string) {
    console.log(`value=${value}`);
    this.keyword = value;
    this.router.navigateByUrl(`/search/${value}`);
  }

  private handleSearchProducts() {
    console.log(this.keyword);
    // now search for the products using keyword
    this.bookService.searchBooks(this.keyword).subscribe(
      data => {
        this.books = data;
      }
    );
  }

  private handleListProducts() {
    // check if "id" parameter is available
    // const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    // if (hasCategoryId) {
    //   // get the "id" param string. convert string to a number using the "+" symbol
    //   this.currentCategoryId = Number(this.route.snapshot.paramMap.get('id'));
    // } else {
    //   // not category id available ... default to category id 1
    //   this.currentCategoryId = 1;
    // }
    // 192-199
    const temp = this.route.snapshot.paramMap.get('id');
    console.log(temp);
    this.currentCategoryId = temp === null || temp === undefined ? 1 : Number(temp);

    if (this.previousCategoryId !== this.currentCategoryId) {
      this.thePageNumber = 1;
    }
    this.previousCategoryId = this.currentCategoryId;

    console.log(`currentCategoryId=${this.currentCategoryId}, thePageNumber=${this.thePageNumber}`);

    // now get the products for the given category id
    this.bookService.getBookListPaginate(this.thePageNumber - 1,
      this.thePageSize,
      this.currentCategoryId).subscribe(
      this.processResult()
    );
  }
  processResult() {
    return data => {
      this.books = data._embedded.books;
      this.thePageNumber = data.page.number + 1;
      this.thePageSize = data.page.size;
      this.theTotalElements = data.page.totalElements;
      console.log(this.books);
    };
  }

  // ngOnDestroy(): void {
  //   this.oktaSignin.remove();
  // }
  addToCart(theBook: Book) {
    console.log(`Adding to cart: ${theBook.name}, ${theBook.unitPrice}`);

      // TODO ... do the real work
    const theCartItem = new CartItem(theBook);

    this.cartService.addToCart(theCartItem);
    }
  updateCartStatus() {

    // subscribe to the cart totalPrice
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );

    // subscribe to the cart totalQuantity
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );
  }
}

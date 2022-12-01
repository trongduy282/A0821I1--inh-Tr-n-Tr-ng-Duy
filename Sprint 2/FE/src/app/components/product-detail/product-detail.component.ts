import { Component, OnInit } from '@angular/core';
import {Book} from '../../common/book';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../../service/book.service';
import {CartService} from '../../services/cart.service';
import {CartItem} from '../../common/cart-item';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  totalPrice = 0.00;
  totalQuantity = 0;
  book: Book = new Book();
  constructor(private bookService: BookService,
              private cartService: CartService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.updateCartStatus();
    this.route.paramMap.subscribe(() => {
      this.handleBookDetails();
    });
  }
  handleBookDetails() {

    // get the "id" param string. convert string to a number using the "+" symbol
    const theBookId: number = +this.route.snapshot.paramMap.get('id');

    this.bookService.getBook(theBookId).subscribe(
      data => {
        this.book = data;
      }
    );
  }


  addToCart() {
    console.log(`Adding to cart: ${this.book.name}, ${this.book.unitPrice}`);
    const theCartItem = new CartItem(this.book);
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

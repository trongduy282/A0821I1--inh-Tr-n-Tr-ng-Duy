import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CartService} from '../../services/cart.service';
import {CheckoutService} from '../../services/checkout.service';
import {Router} from '@angular/router';
import {Order} from '../../common/order';
import {OrderItem} from '../../common/order-item';
import {Purchase} from '../../common/purchase';
import {State} from '../../common/state';
import {Country} from '../../common/country';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  checkoutFormGroup: FormGroup;
  totalPrice = 0;
  totalQuantity = 0;

  constructor(private formBuilder: FormBuilder,
              private cartService: CartService,
              private checkoutService: CheckoutService,
              private router: Router,
              ) {
    render({
    id: '#myPaypalButtons',
    currency: 'USD',
    value: '100',
    onApprove: (details => {
      alert('Giao dịch thành công!');
    })
  }); }

  ngOnInit(): void {
    this.reviewCartDetails();
    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: new FormControl('', [Validators.required, Validators.minLength(2)]),
        lastName:  new FormControl('', [Validators.required, Validators.minLength(2)]),
        email: new FormControl('',
          [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
      }),
      shippingAddress: this.formBuilder.group({
        street: new FormControl('', [Validators.required, Validators.minLength(2)]),
        city: new FormControl('', [Validators.required, Validators.minLength(2)]),
        state: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        zipCode: new FormControl('', [Validators.required, Validators.minLength(2)])
      }),
      // billingAddress: this.formBuilder.group({
      //   street: [''],
      //   city: [''],
      //   state: [''],
      //   country: [''],
      //   zipCode: ['']
      // }),
      creditCard: this.formBuilder.group({
        cardType: new FormControl('', [Validators.required]),
        nameOnCard:  new FormControl('', [Validators.required, Validators.minLength(2)]),
        cardNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]{16}')]),
        securityCode: new FormControl('', [Validators.required, Validators.pattern('[0-9]{3}')]),
        expirationMonth: [''],
        expirationYear: ['']
      })
    });
  }
  // copyShippingAddressToBillingAddress(event) {
  //
  //   if (event.target.checked) {
  //     this.checkoutFormGroup.controls.billingAddress
  //       .setValue(this.checkoutFormGroup.controls.shippingAddress.value);
  //   } else {
  //     this.checkoutFormGroup.controls.billingAddress.reset();
  //   }
  //
  // }
  get firstName() { return this.checkoutFormGroup.get('customer.firstName'); }
  get lastName() { return this.checkoutFormGroup.get('customer.lastName'); }
  get email() { return this.checkoutFormGroup.get('customer.email'); }

  get shippingAddressStreet() { return this.checkoutFormGroup.get('shippingAddress.street'); }
  get shippingAddressCity() { return this.checkoutFormGroup.get('shippingAddress.city'); }
  get shippingAddressState() { return this.checkoutFormGroup.get('shippingAddress.state'); }
  get shippingAddressZipCode() { return this.checkoutFormGroup.get('shippingAddress.zipCode'); }
  get shippingAddressCountry() { return this.checkoutFormGroup.get('shippingAddress.country'); }

  get creditCardType() { return this.checkoutFormGroup.get('creditCard.cardType'); }
  get creditCardNameOnCard() { return this.checkoutFormGroup.get('creditCard.nameOnCard'); }
  get creditCardNumber() { return this.checkoutFormGroup.get('creditCard.cardNumber'); }
  get creditCardSecurityCode() { return this.checkoutFormGroup.get('creditCard.securityCode'); }
  onSubmit() {
    console.log('Handling the submit button');

    if (this.checkoutFormGroup.invalid) {
      this.checkoutFormGroup.markAllAsTouched();
      return;
    }

    // set up order
    const order = new Order();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;

    // get cart items
    const cartItems = this.cartService.cartItems;

    // create orderItems from cartItems
    // - long way
    /*
    let orderItems: OrderItem[] = [];
    for (let i=0; i < cartItems.length; i++) {
      orderItems[i] = new OrderItem(cartItems[i]);
    }
    */

    // - short way of doing the same thingy
    const orderItems: OrderItem[] = cartItems.map(tempCartItem => new OrderItem(tempCartItem));

    // set up purchase
    const purchase = new Purchase();

    // populate purchase - customer
    purchase.customer = this.checkoutFormGroup.controls.customer.value;

    // populate purchase - shipping address
    purchase.shippingAddress = this.checkoutFormGroup.controls.shippingAddress.value;
    // const shippingState: State = JSON.parse(JSON.stringify(purchase.shippingAddress.state));
    // const shippingCountry: Country = JSON.parse(JSON.stringify(purchase.shippingAddress.country));
    // purchase.shippingAddress.state = shippingState.name;
    // purchase.shippingAddress.country = shippingCountry.name;

    // populate purchase - billing address
    // purchase.billingAddress = this.checkoutFormGroup.controls.billingAddress.value;
    // const billingState: State = JSON.parse(JSON.stringify(purchase.billingAddress.state));
    // const billingCountry: Country = JSON.parse(JSON.stringify(purchase.billingAddress.country));
    // purchase.billingAddress.state = billingState.name;
    // purchase.billingAddress.country = billingCountry.name;

    // populate purchase - order and orderItems
    purchase.order = order;
    purchase.orderItems = orderItems;

    // call REST API via the CheckoutService
    this.checkoutService.placeOrder(purchase).subscribe({
        next: response => {
          alert(`Your order has been received.\nOrder tracking number: ${response.orderTrackingNumber}`);

          // reset cart
          this.resetCart();

        },
        error: err => {
          alert(`There was an error: ${err.message}`);
        }
      }
    );

  }
  resetCart() {
    // reset cart data
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);

    // reset the form
    this.checkoutFormGroup.reset();

    // navigate back to the products page
    this.router.navigateByUrl('/books');
  }
  private reviewCartDetails() {
    // subscribe to cartService.totalQuantity
    this.cartService.totalQuantity.subscribe(
      totalQuantity => this.totalQuantity = totalQuantity
    );

    // subscribe to cartService.totalPrice
    this.cartService.totalPrice.subscribe(
      totalPrice => this.totalPrice = totalPrice
    );
  }
}

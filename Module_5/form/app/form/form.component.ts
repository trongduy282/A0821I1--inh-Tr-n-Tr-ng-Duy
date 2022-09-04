import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  userForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    // pwGroup: new FormGroup({
    newPass: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPass: new FormControl('', [Validators.required, Validators.minLength(6)]),
    // }),
    // , this.comparePass
    country: new FormControl('', Validators.required),
    age: new FormControl('', [Validators.required]),
    // , this.checkAge
    gender: new FormControl('', Validators.required),
    phone: new FormControl('', [Validators.required, Validators.pattern('^(\\+84|0)\\d{9}$')])
  });
  constructor() { }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.userForm);
  }
}

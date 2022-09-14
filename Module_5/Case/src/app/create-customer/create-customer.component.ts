import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../customer';
import {CustomerListComponent} from '../customer-list/customer-list.component';
import {CustomerServiceService} from '../customer/customer-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerTypeService} from '../customer-type.service';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  constructor(private customerService: CustomerServiceService,
              private customerType: CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute
  ) {}
  customerTypes: CustomerType[];
  get name() {
    return this.form.get('name');
  }
  get identity() {
    return this.form.get('identity');
  }
  get phone_number() {
    return this.form.get('phone_number');
  }
  get email() {
    return this.form.get('email');
  }
  form: FormGroup;
  id = 0;

  validationMessages = {
    name: [
      {type: 'required', message: 'Tên không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    identity: [
      {type: 'required', message: 'CMND/CCCD không được để trống'},
      {type: 'pattern', message: '9 hoặc 12 số'}
    ],
    phone_number: [
      {type: 'required', message: 'Sđt không được để trống'},
      {type: 'pattern', message: 'bắt đầu 03,05,07,09 và có 8 hoặc 9 số'}
    ],
    email: [
      {type: 'required', message: 'không được để trống'},
      {type: 'pattern', message: 'đuôi chấm @dev.com'}
    ]
  };

  ngOnInit(): void {
    this.customerType.getAll().subscribe(customerTypes => this.customerTypes = customerTypes);
    // this.groupService.getAll().subscribe(groups => this.groups = groups);
    // this.teacherService.getAll().subscribe(teachers => this.teachers = teachers);
    // àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđĐ
    this.form = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]),
      gender: new FormControl('', Validators.required),
      // birthday: new FormControl('', [Validators.required, this.checkBirthday]),
      identity: new FormControl('', [Validators.required, Validators.pattern('^(\\d{9}|\\d{12})$')]),
      phone_number: new FormControl('', [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,9}$')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@dev.com$')]),
      address: new FormControl(),
      customer_type: new FormControl()
      // group: new FormControl('', [Validators.required, this.checkGroup]),
      // teacher: new FormControl('', [Validators.required])
    });

    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      console.log(id);
      if (id !== null) {
        this.id = Number(id);
        this.customerService.findById(this.id).subscribe(customer => {
          this.form.patchValue(customer);
        });
      }
    });
  }
  compare(o1: any, o2: any) {
    if (o1 === null || o2 === null) {
      return false;
    }
    return o1.id === o2.id;
  }

  submit() {
    if (this.form.valid) {
      if (this.id === 0) {
        this.customerService.save(this.form.value).subscribe(
          next => {
            this.router.navigateByUrl('');
          }
        );
      } else {
        this.customerService.update(this.id, this.form.value).subscribe(
          next => {
            this.router.navigateByUrl('');
          }
        );
      }
    }
  }
}

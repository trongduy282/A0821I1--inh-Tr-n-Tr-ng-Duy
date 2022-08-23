import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  ketQua = 0;
  num1 = 0;
  num2 = 0;

  constructor() { }

  ngOnInit(): void {
  }


  tinhToan(num1: string, num2: string, phepTinh: string ) {
    // tslint:disable-next-line:radix
    this.num1 = parseInt(num1);
    // tslint:disable-next-line:radix
    this.num2 = parseInt(num2);
    this.ketQua = 0;

    switch (phepTinh) {
      case '+': {
        this.ketQua = this.num1 + this.num2;
        break;
      }
      case '-': {
        this.ketQua = this.num1 - this.num2;
        break;
      }
      case '*': {
        this.ketQua = this.num1 * this.num2;
        break;
      }
      case '/': {
        this.ketQua = this.num1 / this.num2;
        break;
      }
    }
  }
}

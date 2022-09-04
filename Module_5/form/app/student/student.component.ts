import { Component, OnInit } from '@angular/core';
import {Student} from '../student';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: Student = {
  name: 'Duy',
  age: 28,
  phone: '0123456789'
};
  constructor() { }

  ngOnInit(): void {
  }

  // Change(target: any) {
  //   // @ts-ignore
  //   this.student.age(target.value);
  // }

  changeAge(age: string) {
    this.student.age = Number((age));
  }
}

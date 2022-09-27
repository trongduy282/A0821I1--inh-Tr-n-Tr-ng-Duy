import {Component, OnInit} from '@angular/core';
import {StudentService} from '../../services/student.service';
import {Teacher} from '../../models/teacher';
import {Group} from '../../models/group';
import {GroupService} from '../../services/group.service';
import {TeacherService} from '../../services/teacher.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-student-create-edit',
  templateUrl: './student-create-edit.component.html',
  styleUrls: ['./student-create-edit.component.css']
})
export class StudentCreateEditComponent implements OnInit {
  constructor(private studentService: StudentService,
              private groupService: GroupService,
              private teacherService: TeacherService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  get name() {
    return this.form.get('name');
  }

  // get birthday() {
  //   return this.form.get('birthday');
  // }

  groups: Group[];
  teachers: Teacher[];
  form: FormGroup;
  id = 0;

  validationMessages = {
    name: [
      {type: 'required', message: 'Tên không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    group: [
      {type: 'required', message: 'Nhóm không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    teacher: [
      {type: 'required', message: 'Giáo viên không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    id: [
      {type: 'required', message: 'Mã Sinh Viên không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    projectName: [
      {type: 'required', message: 'Tên không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    birthday: [
      {type: 'required', message: 'Ngay sinh không được để trống'},
      {type: 'checkBirthday', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    email: [
      {type: 'required', message: 'Ngay sinh không được để trống'},
      {type: 'pattern', message: 'Email định dạng abc@def.com'}
    ],
    phone: [
      {type: 'required', message: 'Số Điện Thoại không được để trống'},
      {type: 'pattern', message: 'Số điện thoại dạng 10-12 số'}
    ],
  };

  ngOnInit(): void {
    this.groupService.getAll().subscribe(groups => this.groups = groups);
    this.teacherService.getAll().subscribe(teachers => this.teachers = teachers);

    // this.form = new FormGroup({
    //   id: new FormControl('', Validators.required),
    //   name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđĐ ]+$')]),
    //   group: new FormControl('', [Validators.required, this.checkGroup]),
    //   projectName: new FormControl('', Validators.required),
    //   teacher: new FormControl('', [Validators.required]),
    //   email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@def.com$')]),
    //   phone: new FormControl('', [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,10}$')])
    // });

    this.form = new FormGroup({
      id: new FormControl('', Validators.required),
      name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]),
      group: new FormControl('', [Validators.required]),
      projectName: new FormControl('', Validators.required),
      teacher: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@def.com$')]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,10}$')])
    });

    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      console.log(id);
      if (id !== null) {
        this.id = Number(id);
        this.studentService.findById(this.id).subscribe(student => {
          this.form.patchValue(student);
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

  checkBirthday(c: AbstractControl) {
    const value = c.value;
    const birthday = new Date(value);
    const currentDay = new Date();
    if (birthday < currentDay) {
      return null;
    }
    return {birthdayError: true};
  }

  // checkGroup(c: AbstractControl) {
  //   const value = c.value.name;
  //   if (value === 'Nhóm 1' || value === 'Nhóm 2' || value === 'Nhóm 3') {
  //     return null;
  //   }
  //   return {groupError: true};
  // }

  submit() {
    console.log(1);
    if (this.form.valid) {
      console.log(2);
      if (this.id === 0) {
        console.log(3);
        this.studentService.create(this.form.value).subscribe(
          next => {
            this.router.navigateByUrl('/students');
          }
        );
      } else {
        this.studentService.update(this.form.value).subscribe(
          next => {
            this.router.navigateByUrl('/students');
          }
        );
      }
    }
  }
}

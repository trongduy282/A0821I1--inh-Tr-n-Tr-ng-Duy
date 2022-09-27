import {Component, OnInit} from '@angular/core';
import {StudentService} from '../../services/student.service';
import {Student} from '../../models/student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  indexPagination = 0;
  totalPagination: Array<number>;
  students: Student[];
  totalPages: number;
  studentDelete: Student = {
    id: 0,
    name: '',
    email: '',
    phone: '',
    group: {
      id: 0,
      name: 'Nhóm 0'
    },
    projectName: '',
    teacher: {
      id: 0,
      name: 'Teacher 0'
    }
  };
  p = 1;

  // searchText = '';
  constructor(private studentService: StudentService) {
  }
  setPage(i, event: any) {
    event.preventDefault();
    this.indexPagination = i;
    this.getAllWithPage();
  }
  ngOnInit(): void {
    // this.getAllNotPagination();
    this.getAllWithPage();
  }
  // getAllWithPage() {
  //   this.studentService.getAllStudentsWithPage(this.indexPagination - 1).subscribe(students => {
  //     console.log(students);
  //     this.students = students;
  //   });
  // }
  getAllWithPage() {
    this.studentService.getAllStudentsWithPage(this.indexPagination).subscribe((students) => {
      this.students = students['content'];
      // this.indexPagination = 0;
      this.totalPagination = new Array(students['totalPages']);
      // console.log(students['totalPages']);
      // console.log(students);
      // this.students = students;
    });
  }

  getAllNotPagination() {
    this.studentService.getAllStudentsNotPagination().subscribe(students => {
      const length: number = students.length;
      this.totalPages = length % 3 === 0 ? length / 3 : Math.floor(length / 3) + 1;
      if (this.indexPagination > this.totalPages) {
        this.indexPagination = this.totalPages;
        this.getAllWithPage();
      }
    });
  }

  findStudentDeleteById(id: number) {
    this.studentService.findById(id).subscribe(s => this.studentDelete = s);
  }

  deleteById(id: number) {
    this.studentService.deleteById(id).subscribe((data) => {
      this.ngOnInit();
    });

  }

  firstPage() {
    this.indexPagination = 1;
    this.getAllWithPage();
  }

  lastPage() {
    this.indexPagination = this.totalPages;
    this.getAllWithPage();
  }

  previousPage() {
    if (this.indexPagination > 1) {
      this.indexPagination = this.indexPagination - 1;
      this.getAllWithPage();
    }
  }

  nextPage() {
    if (this.indexPagination < this.totalPages) {
      this.indexPagination = this.indexPagination + 1;
      this.getAllWithPage();
    }
  }

  // search() {
  //   this.studentService.search(this.searchText).subscribe(
  //     students => this.students = students
  //   );
  // }

}

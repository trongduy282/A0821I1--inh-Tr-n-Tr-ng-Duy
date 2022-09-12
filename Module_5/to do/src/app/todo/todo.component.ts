import {Component, OnInit} from '@angular/core';
import {ITodo} from "../ITodo";
import {FormControl, FormGroup, FormsModule} from "@angular/forms";
import {ServiceTodoService} from "../../service/service-todo.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import compile = WebAssembly.compile;
import {Local} from "protractor/built/driverProviders";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  private subscription: Subscription;
  todos: ITodo[] = [];
  contentInput: FormGroup;
  todo:ITodo;
  constructor(
    private _service: ServiceTodoService,
    private _router:Router
  ) {
  }

  ngOnInit(): void {
   this.subscription = this._service.getAll().subscribe(data => {
      this.todos = data;
    }, error => {
      console.log("errors");
    }
    );
    this.contentInput = new FormGroup(
      {
        id: new FormControl(''),
        content: new FormControl(''),
        complete: new FormControl(false)
      }
    )
  }

  toggleTodo(id: number) {
    this.subscription = this._service.getById(id).subscribe(data=>{
      this.todo = data;
      this.todo.complete = !this.todo.complete;
      this.subscription = this._service.update(id, this.todo).subscribe(()=>{
        console.log("success");
        location.reload();
      }, error => {
        console.log("error");
      });
    }, error => {
      console.log("errors");
    })
  }

  change() {
    this._service.save(this.contentInput.value).subscribe(()=>{
      console.log("success");
      alert("Ban da tao thanh cong " +this.contentInput.value.content);
      location.reload();
    }, error => {
      console.log("errors");
    })
  }

  delete(id: number) {
    this._service.delete(id).subscribe(()=>{
      console.log("success");
      location.reload();
    }, error => {
      console.log("error");
    })
  }
}

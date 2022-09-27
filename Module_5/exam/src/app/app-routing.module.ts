import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {StudentListComponent} from './components/student-list/student-list.component';
import {StudentCreateEditComponent} from './components/student-create-edit/student-create-edit.component';


const routes: Routes = [
  {
    path: 'students', component: StudentListComponent
  },
  {
    path: 'students/create', component: StudentCreateEditComponent
  },
  {
    path: 'students/edit/:id', component: StudentCreateEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryDetailComponent} from "./dictionary-detail/dictionary-detail.component";
import {DictionayPageComponentComponent} from "./dictionay-page-component/dictionay-page-component.component";


const routes: Routes = [
  {
    path: 'dictionary',
    component: DictionayPageComponentComponent
  },
  {
    path: 'dictionary/:id',
    component: DictionaryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

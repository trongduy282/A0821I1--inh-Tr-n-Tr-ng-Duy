import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetComponent } from './pet/pet.component';
import {FormsModule} from '@angular/forms';
import { StudentComponent } from './student/student.component';
import { CaculatorComponent } from './caculator/caculator.component';
import { ColorpickerComponent } from './colorpicker/colorpicker.component';
import { ArticleComponent } from './article/article.component';
import { LikeComponent } from './like/like.component';
// import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    PetComponent,
    StudentComponent,
    CaculatorComponent,
    ColorpickerComponent,
    ArticleComponent,
    LikeComponent,
    // HeaderComponent,
    NavbarComponent,
    FooterComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

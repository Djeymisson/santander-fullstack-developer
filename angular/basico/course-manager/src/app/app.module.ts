import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CourseModule } from './components/course.module';
import { CoreModule } from './core/core.module';

const ROUTES: Routes = [
  { path: '', redirectTo: 'courses', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CourseModule,
    CoreModule,
    RouterModule.forRoot(ROUTES),
  ],
  providers: [],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }

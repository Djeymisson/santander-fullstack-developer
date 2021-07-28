import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CourseInfoComponent } from './components/course-info/course-info.component';
import { CourseListComponent } from './components/course-list/course-list.component';
import { FourOhFourComponent } from './components/four-oh-four/FourOhFour.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { StarComponent } from './components/stars/stars.component';
import { ReplacePipe } from './pipes/replace.pipe';

const routes: Routes = [
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/info/:id', component: CourseInfoComponent },
  { path: '', redirectTo: 'courses', pathMatch: 'full' },
  { path: '**', component: FourOhFourComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CourseListComponent,
    StarComponent,
    ReplacePipe,
    NavBarComponent,
    FourOhFourComponent,
    CourseInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

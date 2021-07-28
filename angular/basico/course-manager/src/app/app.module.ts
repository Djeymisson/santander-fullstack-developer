import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CourseListComponent } from './components/course-list/course-list.component';
import { FourOhFourComponent } from './components/FourOhFour/FourOhFour.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { StarComponent } from './components/stars/stars.component';
import { ReplacePipe } from './pipes/replace.pipe';

const routes: Routes = [
  { path: '', redirectTo: 'courses', pathMatch: 'full' },
  { path: 'courses', component: CourseListComponent },
  { path: '**', component: FourOhFourComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CourseListComponent,
    StarComponent,
    ReplacePipe,
    NavBarComponent,
    FourOhFourComponent
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

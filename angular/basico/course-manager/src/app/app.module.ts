import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CourseInfoComponent } from './components/course-info/course-info.component';
import { CourseListComponent } from './components/course-list/course-list.component';
import { FourOhFourComponent } from './components/four-oh-four/FourOhFour.component';
import { NavBarComponent } from './core/components/nav-bar/nav-bar.component';
import { StarComponent } from './shared/components/stars/stars.component';
import { ReplacePipe } from './shared/pipes/replace.pipe';
import { CourseModule } from './components/course.module';
import { CoreModule } from './core/core.module';

const ROUTES: Routes = [
  { path: '', redirectTo: 'courses', pathMatch: 'full' },
  { path: '**', component: FourOhFourComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    FourOhFourComponent
  ],
  imports: [
    CoreModule,
    CourseModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

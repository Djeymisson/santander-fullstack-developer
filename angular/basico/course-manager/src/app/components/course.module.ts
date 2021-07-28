import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { CourseInfoComponent } from "./course-info/course-info.component";
import { CourseListComponent } from "./course-list/course-list.component";
import { StarComponent } from "../shared/components/stars/stars.component";
import { StarModule } from "../shared/components/stars/stars.module";
import { AppPipeModule } from "../shared/pipes/app-pipe.module";

const ROUTES: Routes = [
    { path: 'courses', component: CourseListComponent },
    { path: 'courses/info/:id', component: CourseInfoComponent },
];

@NgModule({
    declarations: [
        CourseListComponent,
        CourseInfoComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        RouterModule.forChild(ROUTES),
        StarModule,
        AppPipeModule
    ]
})
export class CourseModule { }
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Course } from "src/app/models/course";
import { CourseService } from "src/app/services/course.service";

@Component({
    templateUrl: './course-info.component.html'
})
export class CourseInfoComponent implements OnInit {

    course!: Course;

    constructor(private activedRoute: ActivatedRoute, private courseService: CourseService) { }

    ngOnInit(): void {
        var id = this.activedRoute.snapshot.paramMap.get('id');
        if (id != null)
            this.retrieveById(+id);
    }

    retrieveById(id: number): void {
        this.courseService.retrieveById(id).subscribe({
            next: c => this.course = c,
            error: err => console.log('Error', err)
        });
    }

    save(): void {
        this.courseService.save(this.course).subscribe({
            next: c => console.log('Saved!'),
            error: err => console.log(err)
        });
    }

}
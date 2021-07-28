import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
    templateUrl: './course-info.component.html'
})
export class CourseInfoComponent implements OnInit {

    courseId!: number;

    constructor(private activedRoute: ActivatedRoute) { }

    ngOnInit(): void {
        var id = this.activedRoute.snapshot.paramMap.get('id');
        if (id != null)
            this.courseId = +id;
    }

}
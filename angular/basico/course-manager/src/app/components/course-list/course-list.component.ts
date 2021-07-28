import { Component, OnInit } from "@angular/core";
import { CourseService } from "src/app/services/course.service";
import { Course } from "../../models/course";

@Component({
    templateUrl: './course-list.component.html'
})
export class CourseListComponent implements OnInit {

    filteredCourse: Course[] = [];

    _courses: Course[] = [];

    _filterBy!: String;

    constructor(private courseService: CourseService) { }

    ngOnInit(): void {
        this._courses = this.courseService.retrieveAll();
        this.filteredCourse = this._courses;
    }

    set filter(value: String) {
        this._filterBy = value;

        this.filteredCourse =
            this._courses.filter((course: Course) =>
                course.name.toLocaleLowerCase().indexOf(this._filterBy.toLocaleLowerCase()) > -1)
    }

    get filter() {
        return this._filterBy;
    }

}
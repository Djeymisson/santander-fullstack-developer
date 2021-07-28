import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Course } from "../models/course";

@Injectable({
    providedIn: 'root'
})
export class CourseService {

    private courseUrl: string = 'http://localhost:3100/api/courses'

    constructor(private httClient: HttpClient) { }

    retrieveAll(): Observable<Course[]> {
        return this.httClient.get<Course[]>(this.courseUrl);
    }

    retrieveById(id: number): Observable<Course> {
        return this.httClient.get<Course>(`${this.courseUrl}/${id}`)
    }

    save(course: Course): Observable<Course> {
        if (course.id)
            return this.httClient.put<Course>(`${this.courseUrl}/${course.id}`, course);
        else
            return this.httClient.post<Course>(this.courseUrl, course);
    }

}
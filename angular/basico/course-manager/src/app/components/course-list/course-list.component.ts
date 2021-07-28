import { Component, OnInit } from "@angular/core";
import { Course } from "../../models/course";

@Component({
    selector: 'app-course-list',
    templateUrl: './course-list.component.html'
})
export class CourseListComponent implements OnInit {

    courses: Course[] = [];

    ngOnInit(): void {
        this.courses = [
            {
                id: 1,
                name: 'Angular: CLI',
                releaseDate: 'November 2, 2019',
                description: 'Neste curso, os alunos irão obter um grande conhecimento nos principais recursos do CLI.',
                duration: 120,
                code: 'XLF-1212',
                rating: 3,
                price: 12.99,
                imageUrl: '/assets/images/castle.png',
            },
            {
                id: 2,
                name: 'Angular: Forms',
                releaseDate: 'November 4, 2019',
                description: 'Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de Forms.',
                duration: 80,
                code: 'DWQ-3412',
                rating: 3.5,
                price: 24.99,
                imageUrl: '/assets/images/mayan.png',
            },
        ]
    }


}
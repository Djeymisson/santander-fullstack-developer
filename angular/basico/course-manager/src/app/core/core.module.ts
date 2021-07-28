import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FourOhFourComponent } from "./components/four-oh-four/FourOhFour.component";
import { NavBarComponent } from "./components/nav-bar/nav-bar.component";

const ROUTES: Routes = [
    { path: '**', component: FourOhFourComponent }
];

@NgModule({
    declarations: [
        NavBarComponent,
        FourOhFourComponent
    ],
    imports: [
        RouterModule.forChild(ROUTES)
    ],
    exports: [
        NavBarComponent
    ]
})
export class CoreModule { }
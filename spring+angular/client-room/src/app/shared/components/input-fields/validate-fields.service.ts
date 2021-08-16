import { Injectable } from '@angular/core';
import { AbstractControl } from '@angular/forms';

@Injectable({
    providedIn: 'root'
})
export class ValidateFieldsService {

    constructor() { }

    hasErrorCheck(control: AbstractControl, errorName: string): boolean {
        if ((control.dirty || control.touched) && this.hasError(control, errorName)) {
            return true;
        }
        return false;
    }

    hasError(control: AbstractControl, errorName: string): boolean {
        return control.hasError(errorName);
    }

    lengthCheck(control: AbstractControl, errorName: string): number {
        if (control.errors) {
            const error = control.errors[errorName];
            return error.requiredLength || error.min || error.max || 0;
        }
        return 0;
    }
}

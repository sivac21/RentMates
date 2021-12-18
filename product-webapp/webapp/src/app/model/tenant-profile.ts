import { Career } from "./career";
import { College } from "./college";
import { Gender } from "./gender.enum";
import { Questionaire } from "./questionaire";
import { School } from "./school";

export class TenantProfile {

    email: String;
    fullName: String;
    age: Number;
    city: String;
    contactNumber: String;
    gender: Gender;
    state: String;
    hobbies: String[];
    ambition: String;
    passion: String;
    questionaire: Questionaire;
    school: School;
    college: College;
    career: Career;
    image: any;
}

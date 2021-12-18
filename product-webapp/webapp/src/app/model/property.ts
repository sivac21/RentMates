import { Parking } from "./parking.enum";
import { PreferredTenant } from "./preferred-tenant.enum";
import { RoomAmenities} from "./room-amenities";
import { Rules } from "./rules";
import { AvailableAmenities } from "./available-amenities";
import { PlaceAvailableFor } from "./place-available-for.enum";

export class Property
 {
    propertyName: String;
    ownerContactNumber: any;
    roomType: String;
    expectedRent: number;
    advancedDeposit: number;
    roomAmenities: RoomAmenities;
    city: String;
    state: String;
    locality: String;
    nearByPlace: String[];
    placeAvailableFor: PlaceAvailableFor;
    preferredTenant: PreferredTenant;
    foodAvailability: boolean;
    availableFrom: any;
    rules: Rules;
    laundary: String;
    roomCleaningService: String;
    parking: Parking;
    availableAmenities: AvailableAmenities;
    ownedBy : string;
    image :any;
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RegisterComponent } from './register/register.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { UpdateTenantProfileComponent } from './update-tenant-profile/update-tenant-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material/material.module';
import { CreatePropertyComponent } from './create-property/create-property.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterOwnerComponent } from './register-owner/register-owner.component';
import { FooterComponent } from './footer/footer.component';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { TenantRecommendationComponent } from './tenant-recommendation/tenant-recommendation.component';
import { PropertyDetailsComponent } from './property-details/property-details.component';
import { ListAllPropertysComponent } from './list-all-propertys/list-all-propertys.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PropertyCardComponent } from './property-card/property-card.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { HomePageComponent } from './home-page/home-page.component';
import { TenantGroupChatComponent } from './tenant-group-chat/tenant-group-chat.component';
import { ListAllProfilesComponent } from './list-all-profiles/list-all-profiles.component';
import { TenantCardComponent } from './tenant-card/tenant-card.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    NavBarComponent,
    LoginComponent,
    UpdateTenantProfileComponent,
    CreatePropertyComponent,
    RegisterOwnerComponent,
    FooterComponent,
    TenantRecommendationComponent,
    PropertyDetailsComponent,
    ListAllPropertysComponent,
    UserProfileComponent,
    PropertyCardComponent,
    HomePageComponent,
    TenantGroupChatComponent,
    ListAllProfilesComponent,
    TenantCardComponent
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    HttpClientModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule, 
    NgxPaginationModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

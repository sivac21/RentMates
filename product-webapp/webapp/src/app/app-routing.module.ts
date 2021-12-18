import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { UpdateTenantProfileComponent } from './update-tenant-profile/update-tenant-profile.component';
import { CreatePropertyComponent } from './create-property/create-property.component';
import { RegisterOwnerComponent } from './register-owner/register-owner.component';
import { FooterComponent } from './footer/footer.component';
import { TenantRecommendationComponent } from './tenant-recommendation/tenant-recommendation.component';
import { PropertyDetailsComponent } from './property-details/property-details.component';
import { ListAllPropertysComponent } from './list-all-propertys/list-all-propertys.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { TenantGroupChatComponent } from './tenant-group-chat/tenant-group-chat.component';
import { ListAllProfilesComponent } from './list-all-profiles/list-all-profiles.component';

const routes: Routes = [
  {
    path: 'homepage', component: RegisterComponent
  },
  {
    path: '', component: HomePageComponent
  },
  {
    path: 'tenantrecommendation', component: TenantRecommendationComponent
  },
  
  {
    path: 'tenantprofile', component: UpdateTenantProfileComponent
  },
  {
    path: 'tenantgroupchat', component: TenantGroupChatComponent
  },
  {
    path: 'register', component: RegisterComponent
  },
  {
    path: 'register-owner', component: RegisterOwnerComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'footer', component: FooterComponent
  },
  {
    path: 'propertydetails', component: PropertyDetailsComponent
  },
  {
    path: 'listallpropertys', component: ListAllPropertysComponent
  },
  {
    path: 'createproperty', component: CreatePropertyComponent
  },
  {
    path: 'profiles', component: ListAllProfilesComponent
  },
  {
    path: 'home', component: NavBarComponent,
    children: [
      
      {
        path: 'tenantprofile', component: UpdateTenantProfileComponent
      },
      {
        path: 'recommendation', component: TenantRecommendationComponent
      },
      {
        path: 'tenantrecommendation/:email', component: TenantRecommendationComponent
      },
      {
        path: 'createproperty', component: CreatePropertyComponent
      },
      {
        path: '', component: UpdateTenantProfileComponent
      },
      {
        path: 'propertydetails/:propertyname', component: PropertyDetailsComponent
      },
      {
        path: 'properties', component: ListAllPropertysComponent
      },
      {
        path: 'userprofile', component: UserProfileComponent
      },
      {
        path: 'userprofile/:email', component: UserProfileComponent
      },
      {
        path: 'tenantgroupchat', component: TenantGroupChatComponent
      },
      {
        path: 'profiles', component: ListAllProfilesComponent
      },
      {
        path: 'listallpropertys', component: ListAllPropertysComponent
      }    
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

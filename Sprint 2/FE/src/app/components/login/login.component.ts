import {Component, OnDestroy, OnInit} from '@angular/core';
import myAppConfig from '../../config/my-app-config';
import { OktaAuthService } from '@okta/okta-angular';
import * as OktaSignIn from '@okta/okta-signin-widget';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {SecurityService} from '../../service/security/security.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit  {
  // constructor(private oktaAuthService: OktaAuthService) {
  //   // this.oktaSignin = new OktaSignIn({
  //   //   logo: 'assets/images/logo/logo.png',
  //   //   baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
  //   //   clientId: myAppConfig.oidc.clientId,
  //   //   redirectUri: myAppConfig.oidc.redirectUri,
  //   //   authParams: {
  //   //     pkce: true,
  //   //     issuer: myAppConfig.oidc.issuer,
  //   //     scopes: myAppConfig.oidc.scopes
  //   //   }
  //   // });
  //   this.oktaSignin = new OktaSignIn({
  //     logo: 'assets/images/logo/logo.png',
  //     features: {
  //       registration: true
  //     },
  //     baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
  //     clientId: myAppConfig.oidc.clientId,
  //     redirectUri: myAppConfig.oidc.redirectUri,
  //     authParams: {
  //       pkce: true,
  //       issuer: myAppConfig.oidc.issuer,
  //       scopes: myAppConfig.oidc.scopes
  //     }
  //   });
  // }
  loginForm: FormGroup;
  username: string;
  password: string;
  roles: string[] = [];
  checkUserName = false;

  checkPassWord = false;
  isLoggedIn: boolean;
  urlImg: string;
  role: string;
  constructor(private formBuilder: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityService,
              private router: Router) { }

  ngOnInit(): void {
    // this.oktaSignin.remove();
    //
    // this.oktaSignin.renderEl({
    //     el: '#okta-sign-in-widget'}, // this name should be same as div tag id in login.component.html
    //   (response) => {
    //     if (response.status === 'SUCCESS') {
    //       this.oktaAuthService.signInWithRedirect();
    //     }
    //   },
    //   (error) => {
    //     throw error;
    //   }
    // );

    // this.oktaSignin.renderEl({ el: '#okta-sign-in-widget'},
    //   (response: any) => {
    //     if (response.status === 'SUCCESS') {
    //       this.oktaAuthService.signInWithRedirect();
    //     }
    //   },
    //   (error: any) => {
    //     throw error;
    //   });
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      remember_me: false
    });
    if (this.tokenStorageService.getUser()) {
      console.log('day la get user');
      this.securityService.isLoggedIn = true;
      this.role = this.tokenStorageService.getUser().roles[0].roleName;
      this.username = this.tokenStorageService.getUser().account.username;
      this.router.navigateByUrl('');
    }
  }

  // ngOnDestroy(): void {
  //   this.oktaSignin.remove();
  // }
  submit() {
    console.log(this.loginForm.value);
    this.securityService.login(this.loginForm.value).subscribe((data) => {
        console.log(data);
        if (this.loginForm.value.remember_me === true) {
          this.tokenStorageService.saveUserLocal(data);
          this.tokenStorageService.saveTokenLocal(data.jwtToken);
        } else {
          this.tokenStorageService.saveUserLocal(data);
          this.tokenStorageService.saveTokenLocal(data.jwtToken);
        }
        this.username = this.tokenStorageService.getUser().account.username;
        this.role = this.tokenStorageService.getUser().account.roles.roleName;
      },
      () => {},
      () => {
        window.location.assign('');
        // this.router.navigateByUrl('');
        alert('thanh cong');
      }
    );
  }

}

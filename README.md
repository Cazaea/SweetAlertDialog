# The original project（sweet-alert-dialog） is updated

Original project address:[https://github.com/pedant/sweet-alert-dialog](https://github.com/pedant/sweet-alert-dialog)

Sweet Alert Dialog
===================
SweetAlert for Android, a beautiful and clever alert dialog

[![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Sweet%20Alert%20Dialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1065)

[中文版](https://github.com/cazaea/SweetAlertDialog/blob/master/README.zh.md)

[Demo Download](https://github.com/pedant/sweet-alert-dialog/releases/download/v1.1/sweet-alert-sample-v1.1.apk)

## ScreenShot
![image](https://github.com/pedant/sweet-alert-dialog/raw/master/change_type.gif)

## Setup
The simplest way to use SweetAlertDialog is to add the library as aar dependency to your build.

**Gradle**(Module)

```
dependencies {
	        implementation 'com.github.yuxiaohui78:SweetAlertDialog:1.1.1'
	}
```

**Gradle**(Project)

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        ...
    }
}
```
 

## Usage

show material progress

```
SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
    pDialog.setTitleText("Loading");
    pDialog.setCancelable(false);
    pDialog.show();
```

![image](https://github.com/pedant/sweet-alert-dialog/raw/master/play_progress.gif)

You can customize progress bar dynamically with materialish-progress methods via **SweetAlertDialog.getProgressHelper()**:

 - resetCount()
 - isSpinning()
 - spin()
 - stopSpinning()
 - getProgress()
 - setProgress(float progress)
 - setInstantProgress(float progress)
 - getCircleRadius()
 - setCircleRadius(int circleRadius)
 - getBarWidth()
 - setBarWidth(int barWidth)
 - getBarColor()
 - setBarColor(int barColor)
 - getRimWidth()
 - setRimWidth(int rimWidth)
 - getRimColor()
 - setRimColor(int rimColor)
 - getSpinSpeed()
 - setSpinSpeed(float spinSpeed)
 
 - setDialogWidth (int dpWidth)
 - setDialogHeight (int dpHeight)
 - setDialogLayout (int dpWidth, int dpHeight)
 

thanks to the project [materialish-progress](https://github.com/pnikosis/materialish-progress) and [@pedant](https://github.com/pedant) participation.

more usages about progress, please see the sample.

Touch the outside to cancel the dialog ：

    SweetAlertDialog sd = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
        .setCustomImage(R.drawable.pill_icon)
        .setTitleText("3:00PM")
        .setContentText("Asprin 50 mg. Take 2 pills")
        .setNeutralText("Later")
        .setCancelText("Skip it")
        .setConfirmText("Take it!");
	
     sd.setCancelable(true);
     sd.setCanceledOnTouchOutside(true);
     sd.show();
     sd.setDialogWidth (300); //dynamically to change the dialog width (unit is dp)
     


Add a neutral button ：

    new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
        .setCustomImage(R.drawable.pill_icon)
        .setTitleText("3:00PM")
        .setContentText("Asprin 50 mg. Take 2 pills")
        .setNeutralText("Later")
        .setCancelText("Skip it")
        .setConfirmText("Take it!")
        .show();



A basic message：

    new SweetAlertDialog(this)
        .setTitleText("Here's a message!")
        .setConfirmText("OK") // Do not set the property, do not show the button
        .show();

A title with a text under：

    new SweetAlertDialog(this)
        .setTitleText("Here's a message!")
        .setContentText("It's pretty, isn't it?")
        .setConfirmText("OK")
        .show();

A error message：

    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
        .setTitleText("Oops...")
        .setContentText("Something went wrong!")
        .setConfirmText("OK")
        .show();

A warning message：

    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .show();

A success message：

    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
        .setTitleText("Good job!")
        .setContentText("You clicked the button!")
        .show();

A message with a custom icon：

    new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
        .setTitleText("Sweet!")
        .setContentText("Here's a custom image.")
        .setCustomImage(R.drawable.custom_img)
        .show();

Bind the listener to confirm button：

    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                sDialog.dismissWithAnimation();
            }
        })
        .show();

Show the cancel button and bind listener to it：

    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setCancelText("No,cancel plx!")
        .setConfirmText("Yes,delete it!")
        .showCancelButton(true)
        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                sDialog.cancel();
            }
        })
        .show();

 **Change** the dialog style upon confirming：

    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                sDialog
                    .setTitleText("Deleted!")
                    .setContentText("Your imaginary file has been deleted!")
                    .setConfirmText("OK")
                    .setConfirmClickListener(null)
                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
            }
        })
        .show();
        
 

[more android tech shares: cazaea.com](http://www.cazaea.com)

## License

    Anti 996 License Version 1.0 (Draft)
    
    Copyright (c) 2017 Cazaea(http://cazaea.com)
       
    Permission is hereby granted to any individual or legal entity
    obtaining a copy of this licensed work (including the source code,
    documentation and/or related items, hereinafter collectively referred
    to as the "licensed work"), free of charge, to deal with the licensed
    work for any purpose, including without limitation, the rights to use,
    reproduce, modify, prepare derivative works of, distribute, publish 
    and sublicense the licensed work, subject to the following conditions:
    
    1. The individual or the legal entity must conspicuously display,
    without modification, this License and the notice on each redistributed 
    or derivative copy of the Licensed Work.
    
    2. The individual or the legal entity must strictly comply with all
    applicable laws, regulations, rules and standards of the jurisdiction
    relating to labor and employment where the individual is physically
    located or where the individual was born or naturalized; or where the
    legal entity is registered or is operating (whichever is stricter). In
    case that the jurisdiction has no such laws, regulations, rules and
    standards or its laws, regulations, rules and standards are
    unenforceable, the individual or the legal entity are required to
    comply with Core International Labor Standards.

    3. The individual or the legal entity shall not induce or force its
    employee(s), whether full-time or part-time, or its independent
    contractor(s), in any methods, to agree in oral or written form, to
    directly or indirectly restrict, weaken or relinquish his or her
    rights or remedies under such laws, regulations, rules and standards
    relating to labor and employment as mentioned above, no matter whether
    such written or oral agreement are enforceable under the laws of the
    said jurisdiction, nor shall such individual or the legal entity
    limit, in any methods, the rights of its employee(s) or independent
    contractor(s) from reporting or complaining to the copyright holder or
    relevant authorities monitoring the compliance of the license about
    its violation(s) of the said license.
    
    THE LICENSED WORK IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
    IN NO EVENT SHALL THE COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM,
    DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
    OTHERWISE, ARISING FROM, OUT OF OR IN ANY WAY CONNECTION WITH THE
    LICENSED WORK OR THE USE OR OTHER DEALINGS IN THE LICENSED WORK.

Clickable Adapter for RecyclerView
========

Clickable adapter which will inform selected position to Activity/Fragment.  Also help you in avoiding repetitive code for BindView.

Gradle
--------

Add it in your root build.gradle at the end of repositories in your project module:
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add the dependency in you app module:
```groovy
dependencies {
	       compile 'com.github.rahulkapoor1:ClickableAdapter:v1'
	     }
```

Usage
=======
Extend your adapter with ```BaseAdapter<CustomItem>```
```java
public class MyCustomAdapter extends BaseAdapter<CustomItem>
```
Return your View which is going to visible in ```RecyclerView```.
```java
@Override
    protected int getItemView() {
        // view id which is going to inflate
        return R.layout.item_adapter;
    }
```
List down your views which are going to display on UI with custom values.
```java
@Override
    protected int[] getResIdOfInflatedViews() {
        // id of views which are going to display on UI with custom values
        return new int[]{R.id.tv_first_name, R.id.tv_last_name};
    }
```
Now set values on View easily.
```java
@Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {

        // Get current item which is going to display on UI
        final CustomItem item = getItem(position);

        // Views mapping
        final TextView tvFirstName = (TextView)holder.getViewById(R.id.tv_first_name);
        final TextView tvLastName = (TextView)holder.getViewById(R.id.tv_last_name);

        // Set values
        tvFirstName.setText(item.getFirstName());
        tvLastName.setText(item.getLastName());
    }
```

Example files are added. Enjoy!
=======
MIT License
=======
Copyright 2017 Rasi Mobile

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

# Capel Bottom Navigation

A **simple, curved and material-style Bottom Navigation** for Android written in **Kotlin** with ❤️.

It is lightweight, customizable, and easy to integrate with **Fragments, ViewBinding, or DataBinding**.

---


## 📱 Preview

![Capel Bottom Navigation Demo](https://raw.githubusercontent.com/CapelDev/capel-bottom-navigation/master/resources/Preview.gif)

---

## ✨ Features

* Curved Material Design Bottom Navigation
* Lightweight and easy to use
* Supports **Fragments**
* Works with **ViewBinding & DataBinding**
* Customizable colors and fonts
* Badge counter support
* Click & show listeners
* Smooth animation

---

## 📦 Installation

Add the dependency in your **module `build.gradle`**:

```groovy
dependencies {
    implementation("io.github.capeldev:capel-bottom-navigation:1.0.0")
}
```

If you are using **Java**, make sure Kotlin is enabled in your project.

---

## 🔧 Enable DataBinding

Add this inside your **module `build.gradle`**:

```groovy
android {
    buildFeatures {
        dataBinding = true
    }
}
```

You can also use **ViewBinding** if preferred.

---

## 🧩 Layout Setup

Add **Capel Bottom Navigation** in your XML layout.

```xml
<capel.bottomnavigation.CapelBottomNavigation
    android:id="@+id/bottomNavigation"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

Add a **Fragment container** where fragments will be loaded.

```xml
<FrameLayout
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

## 🚀 Usage (Kotlin)

Initialize the Bottom Navigation using **ViewBinding/DataBinding**.

```kotlin
val bottomNavigation = binding.bottomNavigation

bottomNavigation.add(CapelBottomNavigation.Model(1, R.drawable.home_icon))
bottomNavigation.add(CapelBottomNavigation.Model(2, R.drawable.category_icon))
```

Set the **default selected tab**.

```kotlin
bottomNavigation.show(1, true)
```

---

## 📱 Fragment Navigation Example

Use `setOnShowListener` to load fragments.

```kotlin
bottomNavigation.setOnShowListener {

    val fragment = when (it.id) {
        1 -> HomeFragment()
        2 -> CategoryFragment()
        else -> HomeFragment()
    }

    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .commit()
}
```

Handle **menu click events**.

```kotlin
bottomNavigation.setOnClickMenuListener {
    // YOUR CODES
}
```

---

## 🧾 Full Example

```kotlin
val bottomNavigation = binding.bottomNavigation

bottomNavigation.add(CapelBottomNavigation.Model(1, R.drawable.home_icon))
bottomNavigation.add(CapelBottomNavigation.Model(2, R.drawable.category_icon))

bottomNavigation.show(1, true)

bottomNavigation.setOnShowListener {

    val fragment = when (it.id) {
        1 -> HomeFragment()
        2 -> CategoryFragment()
        else -> HomeFragment()
    }

    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .commit()
}

bottomNavigation.setOnClickMenuListener {
    // Handle click event
}
```

---

## 🧩 Fragment Example

```kotlin
class HomeFragment : Fragment(R.layout.fragment_home)

class CategoryFragment : Fragment(R.layout.fragment_category)
```

---

## 🎨 Customization

You can customize the Bottom Navigation using XML attributes.

```xml
<capel.bottomnavigation.CapelBottomNavigation
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:capel_circleColor="#ffffff"
    app:capel_backgroundBottomColor="#ffffff"
    app:capel_backgroundColor="#ff6f00"
    app:capel_textColor="#ffffff"
    app:capel_fontFamily="fonts/SourceSansPro-Regular.ttf"
    app:capel_defaultIconColor="#90a4ae"
    app:capel_rippleColor="#2f424242"
    app:capel_selectedIconColor="#3c415e"
    app:capel_shadowColor="#1f212121"
    app:capel_hasAnimation="true"/>
```

You can also change these values **programmatically in Kotlin or Java**.

---

## 🔔 Counter Badge

Set badge counter on a specific tab.

```kotlin
bottomNavigation.setCount(CELL_ID, "5")
```

Clear badge.

```kotlin
bottomNavigation.clearCount(CELL_ID)
```

Clear all badges.

```kotlin
bottomNavigation.clearAllCounts()
```

---

## 🎯 Set Default Tab

```kotlin
bottomNavigation.show(CELL_ID)
```

Example:

```kotlin
bottomNavigation.show(1, true)
```

---

## 📜 License

MIT License

Copyright (c) 2026 Capel

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files.

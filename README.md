# Custom Layouts Application
🧩 AppToolbar – Custom Android Toolbar
AppToolbar is a customizable Android ConstraintLayout-based toolbar component built with Kotlin and ViewBinding. It simplifies common toolbar use-cases like setting titles, controlling visibility of back and menu icons, and customizing icon click behaviors—all while supporting XML attributes for clean layout integration.

# ✨ Features
<li>✅ XML - attribute configurable title, left (back) icon, and right (menu) icon
<li>🖼️ Custom right icon via drawable
<li>🔙 Back icon visibility toggle
<li>🎯 Click listeners for both icons
<li>🔤 Optional title text in all caps

# 🧱 Layout & Design
This toolbar uses:

<li>ConstraintLayout
<li>ViewBinding (AppToolbarBinding)
<li>Vector/Bitmap scaling for icon consistency
<li>Padding and sizing handled via XML or styleable props

# 📦 Component API
<li><b>setTitle(title: String) -
</b>
Sets or updates the toolbar title programmatically.

<li><b>onBackClicked(listener: (View) -> Unit) -</b>
Sets the click listener for the left/back icon.

<li><b>onRightIconClicked(listener: (View) -> Unit) -</b>
Sets the click listener for the right/menu icon.

<li><b>updateRightIcon(drawable: Drawable) -</b>
Updates the right icon at runtime.

# 🔧 Built With
Kotlin<br>
Android ViewBinding<br>
Custom Attributes (attrs.xml)<br>
Scalable Drawable Handling<br>


 

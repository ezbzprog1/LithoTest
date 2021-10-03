package com.example.lithotest

import androidx.core.text.TextDirectionHeuristicsCompat
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.sections.widget.ViewPagerComponent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo
import com.facebook.litho.widget.Text
import com.facebook.litho.widget.TextInput
import com.facebook.yoga.YogaDirection

@LayoutSpec
object BaseViewPagerSpec {

    @OnCreateLayout
    fun onCreateLayout(componentContext: ComponentContext): Component {
        return ViewPagerComponent.create<Any>(componentContext)
            .dataDiffSection(
                DataDiffSection.create<Any>(SectionContext(componentContext))
                    .data(
                        listOf(
                            Column.create(componentContext)
                                .layoutDirection(YogaDirection.RTL)
                                .child(
                                    Text.create(componentContext)
                                        .layoutDirection(YogaDirection.RTL)
                                        .textDirection(TextDirectionHeuristicsCompat.RTL)
                                        .text("page 1")
                                )
                                .child(
                                    TextInput.create(componentContext)
                                        .layoutDirection(YogaDirection.RTL)
                                        .multiline(false)
                                        .heightDip(40f)
                                        .widthDip(100f)
                                )
                                .build(),
                            Column.create(componentContext)
                                .layoutDirection(YogaDirection.RTL)
                                .child(
                                    Text.create(componentContext)
                                        .layoutDirection(YogaDirection.RTL)
                                        .textDirection(TextDirectionHeuristicsCompat.RTL)
                                        .text("page 2")
                                )
                                .child(
                                    TextInput.create(componentContext)
                                        .layoutDirection(YogaDirection.RTL)
                                        .multiline(true)
                                        .heightDip(40f)
                                        .widthDip(100f)
                                )
                                .build(),
                            Column.create(componentContext)
                                .layoutDirection(YogaDirection.RTL)
                                .child(
                                    Text.create(componentContext)
                                        .textDirection(TextDirectionHeuristicsCompat.RTL)
                                        .layoutDirection(YogaDirection.RTL)
                                        .text("page 3")
                                )
                                .child(
                                    TextInput.create(componentContext)
                                        .multiline(false)
                                        .layoutDirection(YogaDirection.RTL)
                                        .heightDip(40f)
                                        .widthDip(100f)
                                )
                                .build(), Column.create(componentContext)
                                .layoutDirection(YogaDirection.RTL)
                                .child(
                                    Text.create(componentContext)
                                        .textDirection(TextDirectionHeuristicsCompat.RTL)
                                        .layoutDirection(YogaDirection.RTL)
                                        .text("page 4")
                                )
                                .child(
                                    TextInput.create(componentContext)
                                        .multiline(false)
                                        .layoutDirection(YogaDirection.RTL)
                                        .heightDip(40f)
                                        .widthDip(100f)
                                )
                                .build(),
                        )
                    )
                    .renderEventHandler(BaseViewPager.onRender(componentContext))
                    .build()
            )
            .heightDip(500f)
            .widthDip(300f)
            .build()
    }

    @OnEvent(RenderEvent::class)
    fun onRender(componentContext: ComponentContext, @FromEvent model: Component): RenderInfo {
        return ComponentRenderInfo.create()
            .component(model)
            .build()
    }
}
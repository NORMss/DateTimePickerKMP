package com.norm.mydatetimepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import network.chaintech.ui.datepicker.WheelDatePickerView
import network.chaintech.ui.timepicker.WheelTimePickerView
import network.chaintech.utils.DateTimePickerView
import network.chaintech.utils.now
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showTimePicker by remember {
            mutableStateOf(false)
        }

        var showDataPicker by remember {
            mutableStateOf(false)
        }


        WheelTimePickerView(
            showTimePicker = showTimePicker,
            height = 200.dp,
            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
            rowCount = 3,
            onDoneClick = {
                showTimePicker = false
                println("DONE: $it")
            },
            onDismiss = {
                showTimePicker = false
                println("Dismissed")
            },
            titleStyle = TextStyle(
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.8f),
            ),
            doneLabelStyle = TextStyle(
                fontSize = MaterialTheme.typography.body2.fontSize,
                color = MaterialTheme.colors.primary,
            ),
            minTime = LocalTime.now(),
        )

        WheelDatePickerView(
            showDatePicker = showDataPicker,
            height = 200.dp,
            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
            rowCount = 3,
            onDoneClick = {
                showDataPicker = false
                println("DONE: $it")
            },
            onDismiss = {
                showDataPicker = false
                println("Dismissed")
            },
            titleStyle = TextStyle(
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.8f),
            ),
            doneLabelStyle = TextStyle(
                fontSize = MaterialTheme.typography.body2.fontSize,
                color = MaterialTheme.colors.primary,
            ),
            yearsRange = LocalDate.now().year..2050,
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    showTimePicker = true
                }
            ) {
                Text(
                    text = "Open TimePicker"
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Button(
                onClick = {
                    showDataPicker = true
                }
            ) {
                Text(
                    text = "Open DataPicker"
                )
            }
        }
    }
}
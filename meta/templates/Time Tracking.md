## Time Tracking 
- 06:00-06:30 - #administrative AutoTask/IT Glue 
- 
```dataviewjs 
const tracked = {} 
dv.pages('"<% tp.file.folder(true) %>/<% tp.file.title %>"').file.lists 
  .where(x => x.section.subpath === "Time Tracking").array() 
  .forEach(x => { 
    // Find the start/end times for each bullet point 
    const times = x.text.match(/^(\d{2}:\d{2})-(\d{2}:\d{2})/) 
    if (times) { 
      const start = moment(times[1], 'HH:mm') 
      const end = moment(times[2], 'HH:mm') 
      const minutes = moment.duration(end.diff(start)).asMinutes() 
      const date = x.path.match(/(\d{4}-\d{2}-\d{2})/)[1] 
      const week = moment(date).format('YYYY, [Week] WW') 
      if (!tracked[week]) tracked[week] = {} 
      if (tracked[week][date]) { 
        tracked[week][date].minutes += minutes 
      } else { 
        tracked[week][date] = { 
          path: x.path, 
          minutes: minutes 
        } 
      } 
    } 
  }) 
const hours = minutes => (minutes / 60).toFixed(1) 
const table = [] 
Object.keys(tracked).sort((a, b) => b.localeCompare(a)) 
  .forEach(weekDate => { 
    // Push weekly value 
    const week = tracked[weekDate] 
    //const weekTime = Object.values(week).reduce((prev, curr) => prev + curr.minutes, 0) 
    //table.push([weekDate, '**' + hours(weekTime) + '**']) 
    // Push daily values 
    Object.keys(week).sort((a, b) => b.localeCompare(a)) 
      .forEach(date => { 
        const link = `– [[${week[date].path}#Time Tracking|${moment(date).format('dddd D MMMM')}]]` 
        //table.push([link, '– ' + hours(week[date].minutes)]) 
        table.push(['- ' + hours(week[date].minutes)]) 
      }) 
  }) 
dv.table(['Hours'], table) 
``` 
```dataviewjs 
const tracked = {} 
dv.pages('"<% tp.file.folder(true) %>/<% tp.file.title %>"').file.lists 
  .where(x => x.section.subpath === "Time Tracking").array() 
  .forEach(x => { 
    // Find the start/end times for each bullet point 
    const times = x.text.match(/^(\d{2}:\d{2})-(\d{2}:\d{2}) - #billable/) 
    if (times) { 
      const start = moment(times[1], 'HH:mm') 
      const end = moment(times[2], 'HH:mm') 
      const minutes = moment.duration(end.diff(start)).asMinutes() 
      const date = x.path.match(/(\d{4}-\d{2}-\d{2})/)[1] 
      const week = moment(date).format('YYYY, [Week] WW') 
      if (!tracked[week]) tracked[week] = {} 
      if (tracked[week][date]) { 
        tracked[week][date].minutes += minutes 
      } else { 
        tracked[week][date] = { 
          path: x.path, 
          minutes: minutes 
        } 
      } 
    } 
  }) 
const hours = minutes => (minutes / 60).toFixed(1) 
const table = [] 
Object.keys(tracked).sort((a, b) => b.localeCompare(a)) 
  .forEach(weekDate => { 
    // Push weekly value 
    const week = tracked[weekDate] 
    //const weekTime = Object.values(week).reduce((prev, curr) => prev + curr.minutes, 0) 
    //table.push([weekDate, '**' + hours(weekTime) + '**']) 
    // Push daily values 
    Object.keys(week).sort((a, b) => b.localeCompare(a)) 
      .forEach(date => { 
        const link = `– [[${week[date].path}#Time Tracking|${moment(date).format('dddd D MMMM')}]]` 
        //table.push([link, '– ' + hours(week[date].minutes)]) 
        table.push(['- ' + hours(week[date].minutes)]) 
      }) 
  }) 
dv.table(['Billable Hours'], table) 
```
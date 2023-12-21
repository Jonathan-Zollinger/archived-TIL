irm -Uri "http://127.0.0.1:8697/api/vms/R6I7E8U2EP9GR5A1GJIFMKT3NB7KP2D0/power" -Method "put" -Headers @{'Accept'='application/vnd.vmware.vmw.rest-v1+json'; 'Authorization'='Basic am9uYXRoYW46VHJpVmlyIzE='; 'Content-Type'='application/vnd.vmware.vmw.rest-v1+json'} -Body "on"


### get all vms

irm -Uri "http://127.0.0.1:8697/api/vms" -Method "get" -Headers @{'Accept'='application/vnd.vmware.vmw.rest-v1+json'; 'Authorization'='Basic am9uYXRoYW46VHJpVmlyIzE='; 'Content-Type'='application/vnd.vmware.vmw.rest-v1+json'}

### start vm
irm -Uri "http://127.0.0.1:8697/api/vms/$($VmId)/power" -Method "put" -Headers @{'Accept'='application/vnd.vmware.vmw.rest-v1+json'; 'Authorization'='Basic am9uYXRoYW46VHJpVmlyIzE='; 'Content-Type'='application/vnd.vmware.vmw.rest-v1+json'} -Body "on"

### query VM IP

irm -Uri "http://127.0.0.1:8697/api/vms/$($VmId)/ip" -Method "get" -Headers @{'Accept'='application/vnd.vmware.vmw.rest-v1+json'; 'Authorization'='Basic am9uYXRoYW46VHJpVmlyIzE='; 'Content-Type'='application/vnd.vmware.vmw.rest-v1+json'}

https://github.com/Jonathan-Zollinger/vm-cli/blob/main/docs/README.md#documentation-for-api-endpoints

### register new vm
[register vm](https://github.com/Jonathan-Zollinger/vm-cli/blob/main/docs/VMManagementApi.md#RegisterVM) & [body](https://github.com/Jonathan-Zollinger/vm-cli/blob/main/docs/VmRegisterParameter.md)

$body = @{Name='COADev-Ubuntu';Path='C:\Users\Jonathan\Documents\Virtual Machines\COADev-Ubuntu\COADev-Ubuntu\COA Dev - Ubuntu.vmx'} | ConvertTo-Json

irm -uri "http://127.0.0.1:8697/api/vms/registration" -Method "post" -Headers @{'Accept'='application/vnd.vmware.vmw.rest-v1+json'; 'Authorization'='Basic am9uYXRoYW46VHJpVmlyIzE='; 'Content-Type'='application/vnd.vmware.vmw.rest-v1+json'} -Body $body

### Start vmrest headless

`Start-Process pwsh -ArgumentList "C:\Program Files (x86)\VMware\VMware Workstation\vmrest.exe" -WindowStyle Hidden
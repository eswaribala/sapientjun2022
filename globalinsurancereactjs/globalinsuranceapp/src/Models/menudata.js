export const items = [
    {
        label:'Policy',
        icon:'pi pi-fw pi-file',
        items:[
            {
                label:'New',
                icon:'pi pi-fw pi-plus',
                items:[
                    {
                        label:'Policy-Create',
                        icon:'pi pi-fw pi-bookmark',
                        command: () => { window.location.href = "/Policy-Create" }

                    },
                    {
                        label:'Policy-View',
                        icon:'pi pi-fw pi-video',
                        command: () => { window.location.href = "/Policy-View" }
                    },

                ]
            },
            {
                label:'Policy-Delete',
                icon:'pi pi-fw pi-trash',
                command: () => { window.location.href = "/Policy-Delete" }
            },
            {
                separator:true
            },
            {
                label:'Policy-Export',
                icon:'pi pi-fw pi-external-link',
                command: () => { window.location.href = "/Policy-Export" }
            }
        ]
    },
    {
        label:'Claim',
        icon:'pi pi-fw pi-pencil',
        items:[
            {
                label:'Claim-Create',
                icon:'pi pi-fw pi-align-left',
                command: () => { window.location.href = "/Claim-Create" }
            },
            {
                label:'Claim-Edit',
                icon:'pi pi-fw pi-align-right',
                command: () => { window.location.href = "/Claim-Edit" }
            },
            {
                label:'Claim-View',
                icon:'pi pi-fw pi-align-center',
                command: () => { window.location.href = "/Claim-View" }
            },
            {
                label:'Claim-Delete',
                icon:'pi pi-fw pi-align-justify',
                command: () => { window.location.href = "/Claim-Delete" }
            },

        ]
    },
    {
        label:'Users',
        icon:'pi pi-fw pi-user',
        items:[
            {
                label:'Users-New',
                icon:'pi pi-fw pi-user-plus',
                command: () => { window.location.href = "/Users-New" }

            },
            {
                label:'Users-Delete',
                icon:'pi pi-fw pi-user-minus',
                command: () => { window.location.href = "/Users-Delete" }

            },
            {
                label:'Search',
                icon:'pi pi-fw pi-users',
                items:[
                    {
                        label:'Filter',
                        icon:'pi pi-fw pi-filter',
                        items:[
                            {
                                label:'Search-Print',
                                icon:'pi pi-fw pi-print',
                                command: () => { window.location.href = "/Search-Print" }
                            }
                        ]
                    },
                    {
                        icon:'pi pi-fw pi-bars',
                        label:'Search-List',
                        command: () => { window.location.href = "/Search-List" }
                    }
                ]
            }
        ]
    },
    {
        label:'Refund',
        icon:'pi pi-fw pi-calendar',
        items:[
            {
                label:'Add',
                icon:'pi pi-fw pi-pencil',
                items:[
                    {
                        label:'Refund-Save',
                        icon:'pi pi-fw pi-calendar-plus',
                        command: () => { window.location.href = "/Refund-Save" }
                    },
                    {
                        label:'Refund-Delete',
                        icon:'pi pi-fw pi-calendar-minus',
                        command: () => { window.location.href = "/Refund-Delete"}
                    },

                ]
            },
            {
                label:'Archive',
                icon:'pi pi-fw pi-calendar-times',
                items:[
                    {
                        label:'Archive-Remove',
                        icon:'pi pi-fw pi-calendar-minus',
                        command: () => { window.location.href = "/Archive-Remove"}
                    }
                ]
            }
        ]
    },
    {
        label:'Quit',
        icon:'pi pi-fw pi-power-off',
        command: () => { window.location.href = "/Quit"}
    }
];

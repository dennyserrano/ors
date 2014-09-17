angular.module('DatasetAppDev', ['DatasetApp', 'ngMockE2E'])
    .run(['$httpBackend', function($httpBackend) {
        var datasets = [
            {
                id: 1,
                name: 'School',
                subDatasetsCount: 10,
                elementsCount: 30
            },
            {
                id: 2,
                name: 'Enrollment',
                subDatasetsCount: 20,
                elementsCount: 50
            },
            {
                id: 3,
                name: 'Facilities',
                subDatasetsCount: 30,
                elementsCount: 70
            },
            {
                id: 4,
                name: 'Personnel',
                subDatasetsCount: 40,
                elementsCount: 90
            }
        ];
        $httpBackend.whenGET('/dataset').respond(datasets);
    }]
);
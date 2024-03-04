package school


import grails.rest.*
import grails.converters.*

class TeacherController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeacherController() {
        super(Teacher)
    }
}

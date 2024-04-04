<template>
    <v-card outlined>
        <v-card-title>
            RegistFreight
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="Origin" v-model="value.origin" :editMode="editMode"/>
            <String label="Destination" v-model="value.destination" :editMode="editMode"/>
            <Number label="Fee" v-model="value.fee" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
            <Number label="FreightOwnerId" v-model="value.freightOwnerId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registFreight"
            >
                RegistFreight
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RegistFreightCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.origin = '';
            this.value.destination = '';
            this.value.fee = 0;
            this.value.status = '';
            this.value.freightOwnerId = 0;
        },
        watch: {
        },
        methods: {
            registFreight() {
                this.$emit('registFreight', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

